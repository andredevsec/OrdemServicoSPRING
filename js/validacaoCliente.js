$(document).ready(function() {
    $('form').submit(function(event) {
      // Impede o envio do formulário
      event.preventDefault();
      
      // Validação do campo Nome
      var name = $('#name').val();
      if (name === '') {
        alert('Por favor, digite o nome do cliente.');
        return;
      }
      
      // Validação do campo Email
      var email = $('#email').val();
      if (email === '') {
        alert('Por favor, digite o email do cliente.');
        return;
      }
      
      // Validação do campo Telefone
      var phone = $('#phone').val();
      if (phone === '') {
        alert('Por favor, digite o telefone do cliente.');
        return;
      }
      
      // Se todos os campos forem válidos, envia o formulário
      $('form').unbind('submit').submit();
    });
  });