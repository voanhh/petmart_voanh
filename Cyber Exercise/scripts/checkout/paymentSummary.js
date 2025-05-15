import {cart} from '../../../../../Projects/javascript-amazon-project/javascript-amazon-project-main/data/cart-class.js';
import {getProducts} from '../../../../../Projects/javascript-amazon-project/javascript-amazon-project-main/data/products.js';
import {getDeliveryOption} from '../../../../../Projects/javascript-amazon-project/javascript-amazon-project-main/data/delivery-option.js';
import {formatMoney} from '../ultis/money.js';

export function renderPaymentSummary(){
  let productPriceCents = 0;
  let deliveryPriceCents = 0;
  cart.cartItems.forEach((cartItem) => {
      const product = getProducts(cartItem.productId);
      productPriceCents += product.priceCents * cartItem.quantity;
      const deliveryOption = getDeliveryOption(Number(cartItem.deliveryOptionId));
      deliveryPriceCents += deliveryOption.price;
  })
  const totalBeforeTax = productPriceCents + deliveryPriceCents;
  const tax = totalBeforeTax * 0.1;
  const totalPrice = totalBeforeTax + tax;

  const paymentSumaryHtml = `
  <div class="payment-summary-title">
      Order Summary
  </div>

  <div class="payment-summary-row">
    <div>Items: (${cart.updateCartQuantity()})</div>
    <div class="payment-summary-money">$${formatMoney(productPriceCents)}</div>
  </div>

  <div class="payment-summary-row">
    <div>Shipping &amp; handling:</div>
    <div class="payment-summary-money">$${formatMoney(deliveryPriceCents)}</div>
  </div>

  <div class="payment-summary-row subtotal-row">
    <div>Total before tax:</div>
    <div class="payment-summary-money">$${formatMoney(totalBeforeTax)}</div>
  </div>

  <div class="payment-summary-row">
    <div>Estimated tax (10%):</div>
    <div class="payment-summary-money">$${formatMoney(tax)}</div>
  </div>

  <div class="payment-summary-row total-row">
    <div>Order total:</div>
    <div class="payment-summary-money">$${formatMoney(totalPrice)}</div>
  </div>

  <button class="place-order-button button-primary .js-place-order-button">
    Place your order
  </button>`;

  document.querySelector('.js-payment-summary')
    .innerHTML = paymentSumaryHtml;
}