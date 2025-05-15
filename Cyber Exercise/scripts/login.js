document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
  
    form.addEventListener("submit", async function (e) {
      e.preventDefault(); // Ngăn submit form mặc định
  
      const formData = new FormData(form);
      const username = formData.get("username");
      const password = formData.get("password");
  
      try {
        const response = await fetch("http://localhost:8080/petmart/login/signin", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams({ username, password }),
        });
  
        const result = await response.json();
  
        if (result.data) {
          alert("Đăng nhập thành công!");
          // Chuyển hướng sang trang chính nếu muốn
          window.location.href = "product.html";
        } else {
          alert("Sai tài khoản hoặc mật khẩu!");
        }
      } catch (error) {
        console.error("Lỗi khi gửi request:", error);
        alert("Có lỗi xảy ra. Vui lòng thử lại sau.");
      }
    });
  });
  