$(document).ready(function() {
    $('form').submit(function(event) {
      // Impede o envio do formulário
      event.preventDefault();
      
      // Validação do campo Nome
      var name = $('#name').val();
      if (name === '') {
        alert('Por favor, digite o nome do produto.');
        return;
      }
      
      // Validação do campo Marca
      var marca = $('#marca').val();
      if (marca === '') {
        alert('Por favor, digite a marca do produto.');
        return;
      }
      
      // Validação do campo Valor
      var valor = $('#valor').val();
      if (valor === '') {
        alert('Por favor, digite o valor do produto.');
        return;
      }
      
      // Se todos os campos forem válidos, envia o formulário
      $('form').unbind('submit').submit();
    });
  });