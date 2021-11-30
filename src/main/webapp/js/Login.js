const login_form = document.getElementById('login-form');
const name_input = document.getElementById('name-input');
const pass = document.getElementById('pass');
const butt_reset = document.getElementById('butt-reset');

login_form.addEventListener('submit', (e) => {
      if(name_input.value == "" || pass.value == "")
      {
            e.preventDefault();
            alert("Dữ liệu đầu vào không chính xác, xin nhập lại!");
      }
})

butt_reset.addEventListener('click', () => {
      name_input.value = "";
      pass.value = "";
})