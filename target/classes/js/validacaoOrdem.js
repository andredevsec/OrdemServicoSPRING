$(document).ready(function() {
  $('form').submit(function(event) {
    // Impede o envio do formulário
    event.preventDefault();
    
    // Validação do campo Cliente
    var cliente = $('#cliente').val();
    if (cliente === '') {
      alert('Por favor, selecione um cliente.');
      return;
    }
    
    // Validação do campo Produto
    var produto = $('#produto').val();
    if (produto === '') {
      alert('Por favor, selecione um produto.');
      return;
    }
    
    // Validação do campo Serviço
    var servico = $('#servico').val();
    if (servico === '') {
      alert('Por favor, digite um serviço.');
      return;
    }
    
    // Se todos os campos forem válidos, envia o formulário
    $('form').unbind('submit').submit();
  });
});
