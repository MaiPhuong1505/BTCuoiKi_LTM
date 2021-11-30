const factor_form = document.getElementById('FactorForm');
const expo_form = document.getElementById('ExpoForm');

factor_form.addEventListener('submit', (e) => {
      let factor_input = document.getElementById('factor-input').value;
      if (factor_input == "" || isInteger(factor_input)) {
            e.preventDefault();
            alert("Dữ liệu đầu vào không chính xác, xin nhập lại!");
      } 
})

expo_form.addEventListener('submit', (e) => {
      let ef_base = document.getElementById('ef-base');
      let ef_ex = document.getElementById('ef-ex');
      if ( ef_base == "" || isInteger(ef_base) || ef_ex == "" || isInteger(ef_ex) ) {
            e.preventDefault();
            alert("Dữ liệu đầu vào không chính xác, xin nhập lại!");
      }
})

function ChangeMode(obj) {
      mod = obj.value;
      if (mod == 2) {
            document.getElementById("ExpoForm").style.display = "block";
            document.getElementById("FactorForm").style.display = "none";
      } else if (mod == 1) {
            document.getElementById("ExpoForm").style.display = "none";
            document.getElementById("FactorForm").style.display = "block";
      }
}

function isInteger(value) {
      value = Number(val);
      if (!Number.isInteger(val)) {
            return false;
      }
      return true;
}