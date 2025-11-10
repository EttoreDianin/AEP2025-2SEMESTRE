const lista = document.getElementById("listaEmpreendedores");
const busca = document.getElementById("busca");

function renderList(data) {
  lista.innerHTML = "";
  data.forEach(e => {
    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML = `
      <img src="${e.imagem || 'https://via.placeholder.com/300x200'}">
      <h3>${e.item}</h3>
      <p><strong>${e.tipo}</strong> — ${e.categoria}</p>
      <p>${e.descricao}</p>
      <p><em>${e.cidade}</em></p>
      <p><strong>R$ ${e.preco || '-'}</strong></p>
      <button onclick="abrirModal()">Entrar em Contato</button>
      <button onclick="editar(${e.id})">Editar</button>
      <button onclick="excluir(${e.id})">Excluir</button>
    `;
    lista.appendChild(card);
  });
}

function editar(id) {
  window.location.href = `cadastro.html?edit=${id}`;
}

function excluir(id) {
  if (confirm("Deseja realmente excluir este item?")) {
    deleteEmpreendedor(id);
    renderList(getEmpreendedores());
  }
}

busca.addEventListener("input", e => {
  const valor = e.target.value.toLowerCase();
  const filtrados = getEmpreendedores().filter(e =>
    e.item.toLowerCase().includes(valor) ||
    e.categoria.toLowerCase().includes(valor) ||
    e.cidade.toLowerCase().includes(valor)
  );
  renderList(filtrados);
});

renderList(getEmpreendedores());
