const STORAGE_KEY = "empreendedoresData";

// Carregar dados
function loadData() {
  const data = localStorage.getItem(STORAGE_KEY);
  return data ? JSON.parse(data) : { empreendedores: [] };
}

// Salvar dados
function saveData(data) {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(data));
}

// Adicionar
function addEmpreendedor(obj) {
  const data = loadData();
  obj.id = Date.now();
  data.empreendedores.push(obj);
  saveData(data);
}

// Editar
function updateEmpreendedor(id, obj) {
  const data = loadData();
  const index = data.empreendedores.findIndex(e => e.id == id);
  if (index !== -1) {
    data.empreendedores[index] = { id, ...obj };
    saveData(data);
  }
}

// Excluir
function deleteEmpreendedor(id) {
  const data = loadData();
  data.empreendedores = data.empreendedores.filter(e => e.id != id);
  saveData(data);
}

// Buscar todos
function getEmpreendedores() {
  return loadData().empreendedores;
}
