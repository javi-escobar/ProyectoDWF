<<<<<<< HEAD
const btnSingIn = document.getElementById("sign-in"),
      btnSingUp = document.getElementById("sing-up"),
      formRegister = document.querySelector(".register"),
      formLogin = document.querySelector(".login");

btnSingIn.addEventListener("click", e => {
     formRegister.classList.add("hide");
     formLogin.classList.remove("hide")
})

btnSingUp.addEventListener("click", e => {
    formLogin.classList.add("hide");
    formRegister.classList.remove("hide")
=======
const btnSingIn = document.getElementById("sign-in"),
      btnSingUp = document.getElementById("sing-up"),
      formRegister = document.querySelector(".register"),
      formLogin = document.querySelector(".login");

btnSingIn.addEventListener("click", e => {
     formRegister.classList.add("hide");
     formLogin.classList.remove("hide")
})

btnSingUp.addEventListener("click", e => {
    formLogin.classList.add("hide");
    formRegister.classList.remove("hide")
>>>>>>> 4c20591ec4e8c6e0165b3c495034c3668ee56ba6
})