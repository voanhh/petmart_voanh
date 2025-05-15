import {cart} from '../../data/cart-class.js';
import { getProducts } from '../../data/products.js';
import {formatMoney} from '../ultis/money.js';
import { renderPaymentSummary } from './paymentSummary.js';
import{ deliveryOption,
        getDeliveryOption,
        calulateDeliveryDate,
} from '../../data/delivery-option.js';
import { renderCheckoutHeader } from './checkoutHeader.js';
import { getPetStoreProduct } from '../../data/pet-store-product.js';
export function renderOrderSumary(){
  let sumaryHtml = '';
  cart.cartItems.forEach((cartItem) => {
    const productId = cartItem.productId;
    const matchingProduct = getPetStoreProduct(productId);

    const deliveryOptionId = Number(cartItem.deliveryOptionId);
    
    const matchingDeliveryOption = getDeliveryOption(deliveryOptionId);
    if (matchingDeliveryOption) {
      
      
      var dateString = calulateDeliveryDate(matchingDeliveryOption);
    } else {
      console.error("Delivery option not found!");
      var dateString = "Unknown";
    }
    

    sumaryHtml += `
    <div class="cart-item-container js-cart-item-container-${matchingProduct.id}">
      <div class="delivery-date">
        Delivery date: ${dateString}
      </div>

      <div class="cart-item-details-grid">
        <img class="product-image"
          src="${matchingProduct.image}">

        <div class="cart-item-details">
          <div class="product-name">
            ${matchingProduct.name}
          </div>
          <div class="product-price">
            ${matchingProduct.getPrice()}
          </div>
          <div class="product-quantity">
            <span>
              Quantity: <span class="quantity-label js-quantity-label-${matchingProduct.id}">${cartItem.quantity}</span>
            </span>
            <span class="update-quantity-link js-update-quantity-link
            link-primary"
            data-product-id="${matchingProduct.id}">
              Update
            </span>
            <input class = "quantity-input js-quantity-input-${matchingProduct.id}">
            <span class = "save-quantity-link js-save-quantity-link link-primary"
            data-product-id="${matchingProduct.id}"
            onkeydown ="">Save</span>
            <span class="delete-quantity-link link-primary js-delete-link"
              data-product-id="${matchingProduct.id}">
              Delete 
            </span>
          </div>
        </div>

        <div class="delivery-options">
          <div class="delivery-options-title">
            Choose a delivery option:
          </div>
          ${deliveryOptionHTML(matchingProduct, cartItem)}
        </div>
      </div>
    </div>
    `;
  });

  function deliveryOptionHTML(matchingProduct, cartItem){
    let html = '';
    deliveryOption.forEach((option) => {
      const dateString = calulateDeliveryDate(option);
      const pricestring = option.price
      === 0
      ? 'FREE'
      : `$${formatMoney(option.price)}`;

      const isSelected = option.id ===
      Number(cartItem.deliveryOptionId);
      html +=`
        <div class="delivery-option js-delivery-option"
        data-product-id="${matchingProduct.id}"
        data-delivery-option-id="${option.id}">
          <input type="radio"
            ${isSelected ? 'checked' : ''}
            class="delivery-option-input"
            name="delivery-option-${matchingProduct.id}">
          <div>
            <div class="delivery-option-date">
              ${dateString}
            </div>
            <div class="delivery-option-price">
              ${pricestring}
            </div>
          </div>
        </div>`
    })
    return html;
  }


  document.querySelector('.js-order-sumary').innerHTML = sumaryHtml;

  document.querySelectorAll('.js-delete-link')
    .forEach((link) => {
      link.addEventListener('click', () => {
        const productId = link.dataset.productId;
        cart.removeItems(productId);
        renderPaymentSummary(); //render the payment sumary again
        renderOrderSumary(); //render the order sumary again
        renderCheckoutHeader(); //render the checkout header again
      })
    })

    

    document.querySelectorAll('.js-update-quantity-link')
    .forEach((link) => {
          link.addEventListener('click', () => {
            const productId = link.dataset.productId; //get id from products
            console.log(productId);
            const container = document.querySelector(`.js-cart-item-container-${productId}`); //get the container of the product
            container.classList.add('is-editing-quantity');
          })
    })

    document.querySelectorAll('.js-save-quantity-link')
    .forEach((link) => {
      link.addEventListener('click', () => {
        const productId = link.dataset.productId; //get id from products
        const container = document.querySelector(`.js-cart-item-container-${productId}`); //get the container of the product
        container.classList.remove('is-editing-quantity');
        const input = document.querySelector(`.js-quantity-input-${productId}`); //get the input of the product
        const newQuantity = Number(input.value);
        cart.updateQuantity(productId, newQuantity); //update the quantity in the cart
        renderPaymentSummary(); //render the payment sumary again
        renderOrderSumary(); //render the order sumary again
        renderCheckoutHeader(); //render the checkout header again
      })
    })

    document.querySelectorAll('.js-delivery-option')
    .forEach((elemment) => {
      elemment.addEventListener('click', () => {
        const {productId, deliveryOptionId} = elemment.dataset; //get the data from the element
        cart.updateDeliveryOptionId(productId, deliveryOptionId); //update the delivery option in the cart
        renderOrderSumary(); //render the order sumary again
        renderPaymentSummary(); //render the payment sumary again
      })
    })
}
  