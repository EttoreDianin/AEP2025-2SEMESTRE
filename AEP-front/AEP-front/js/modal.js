const modal = document.getElementById("modalContato");
const fecharModal = document.getElementById("fecharModal");
const formContato = document.getElementById("formContato");
const mensagemSucesso = document.getElementById("mensagemSucesso");

function abrirModal() {
  modal.style.display = "flex";
  setTimeout(() => modal.classList.add("show"), 10);
}

fecharModal.onclick = () => fechar();

function fechar() {
  modal.classList.remove("show");
  setTimeout(() => modal.style.display = "none", 300);
}

window.onclick = (e) => {
  if (e.target === modal) fechar();
};

formContato.addEventListener("submit", e => {
  e.preventDefault();
  mensagemSucesso.classList.add("show");
  setTimeout(() => {
    mensagemSucesso.classList.remove("show");
    fechar();
    formContato.reset();
  }, 2000);
});
