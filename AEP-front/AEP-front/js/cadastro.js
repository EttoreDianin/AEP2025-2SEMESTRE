const form = document.getElementById("formCadastro");

window.onload = () => {
  const params = new URLSearchParams(window.location.search);
  const id = params.get("edit");
  if (id) carregarEmpreendedor(id);
};

form.addEventListener("submit", e => {
  e.preventDefault();

  const id = document.getElementById("idEmpreendedor").value;
  const obj = {
    nomeEmpreendedor: document.getElementById("nomeEmpreendedor").value,
    tipo: document.getElementById("tipo").value,
    item: document.getElementById("item").value,
    categoria: document.getElementById("categoria").value,
    descricao: document.getElementById("descricao").value,
    preco: document.getElementById("preco").value,
    cidade: document.getElementById("cidade").value,
    imagem: document.getElementById("imagem").value
  };

  if (id) updateEmpreendedor(id, obj);
  else addEmpreendedor(obj);

  window.location.href = "index.html";
});

function carregarEmpreendedor(id) {
  const data = getEmpreendedores().find(e => e.id == id);
  if (data) {
    document.getElementById("idEmpreendedor").value = data.id;
    document.getElementById("nomeEmpreendedor").value = data.nomeEmpreendedor;
    document.getElementById("tipo").value = data.tipo;
    document.getElementById("item").value = data.item;
    document.getElementById("categoria").value = data.categoria;
    document.getElementById("descricao").value = data.descricao;
    document.getElementById("preco").value = data.preco;
    document.getElementById("cidade").value = data.cidade;
    document.getElementById("imagem").value = data.imagem;
  }
}
