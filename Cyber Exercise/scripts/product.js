fetch("http://localhost:8080/api/products")
  .then(response => response.json())
  .then(products => {
    renderProductsGrid(products);
  });

function renderProductsGrid(products){
  let productHtml = '';

  products.forEach((product) => {
    productHtml += `
      <div class="product-container">
        <div class="product-image-container">
          <img class="product-image" src="images/products/default.png"> <!-- Tạm ảnh mặc định -->
        </div>

        <div class="product-name limit-text-to-2-lines">${product.name}</div>

        <div class="product-price">${product.price.toLocaleString()} ₫</div>

        <div class="product-quantity-container">
          <select class="js-product-quantity">
            ${[...Array(10)].map((_, i) => `<option value="${i + 1}">${i + 1}</option>`).join('')}
          </select>
        </div>

        <div class="product-spacer"></div>
        <div class="added-to-cart js-add-to-cart-${product.id}">
          <img src="images/icons/checkmark.png"> Added
        </div>

        <button class="add-to-cart-button button-primary js-add-to-cart-button" data-product-id="${product.id}">
          Add to Cart
        </button>
      </div>
    `;
  });

  document.querySelector('.js-products-grid').innerHTML = productHtml;
}
