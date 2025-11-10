// Alternar entre login e cadastro
const cadastroContainer = document.getElementById("cadastroContainer");
const mostrarCadastro = document.getElementById("mostrarCadastro");
const mostrarLogin = document.getElementById("mostrarLogin");

mostrarCadastro.onclick = () => {
  document.querySelector(".card-login").classList.add("hidden");
  cadastroContainer.classList.remove("hidden");
};

mostrarLogin.onclick = () => {
  cadastroContainer.classList.add("hidden");
  document.querySelector(".card-login").classList.remove("hidden");
};

// Função para obter usuários
function getUsuarios() {
  const data = loadData();
  return data.usuarios || [];
}

// Salvar usuário
function saveUsuario(user) {
  const data = loadData();
  if (!data.usuarios) data.usuarios = [];
  data.usuarios.push(user);
  saveData(data);
}

// Cadastrar novo usuário
document.getElementById("formCadastroUser").addEventListener("submit", e => {
  e.preventDefault();
  const nome = document.getElementById("nomeCadastro").value;
  const email = document.getElementById("emailCadastro").value;
  const senha = document.getElementById("senhaCadastro").value;

  const usuarios = getUsuarios();
  if (usuarios.some(u => u.email === email)) {
    alert("E-mail já cadastrado!");
    return;
  }

  const novo = { id: Date.now(), nome, email, senha };
  saveUsuario(novo);
  alert("Usuário cadastrado com sucesso!");
  window.location.reload();
});

// Login
document.getElementById("formLogin").addEventListener("submit", e => {
  e.preventDefault();
  const email = document.getElementById("emailLogin").value;
  const senha = document.getElementById("senhaLogin").value;

  const usuarios = getUsuarios();
  const user = usuarios.find(u => u.email === email && u.senha === senha);

  if (user) {
    sessionStorage.setItem("usuarioLogado", JSON.stringify(user));
    window.location.href = "index.html";
  } else {
    alert("E-mail ou senha incorretos!");
  }
});

// Se já estiver logado, redireciona direto
window.onload = () => {
  const user = sessionStorage.getItem("usuarioLogado");
  if (user) window.location.href = "index.html";
};
