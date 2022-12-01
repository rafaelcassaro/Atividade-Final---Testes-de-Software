package com.provafinal.testesoftware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrudUsuarioTeste {
	Usuario usuario1 = new Usuario(1,"username1","password1","nome1","email1");
	Usuario usuario2 = new Usuario(2,"username2","password2","nome2","email2");
	Usuario usuario3 = new Usuario(3,"username3","password3","nome3","email3");
	Usuario usuario4 = new Usuario(4,"username4","password4","nome4","email4");
	
	
	//teste que verifica o retorno 'True' ao deletar um usuario que existe, da arrayList Usuario na classe CrudUsuario, pelo metodo DELETE
	//teste realizado atravez da delecao de um objeto usuario que existe, procurando pelo ID dele
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
    public void deveRetornarTrueDelecaoUsuario() {
    	CrudUsuario crud = new CrudUsuario();
    	crud.create(usuario1);
    	crud.create(usuario2);
    	crud.create(usuario3);
    	crud.create(usuario4);
    	
        Assertions.assertTrue(crud.delete(2));
    }
	
	//teste que verifica o retorno 'False' ao deletar um usuario que existe, da arrayList Usuario na classe CrudUsuario, pelo metodo DELETE
	//teste realizado atravez da delecao de um objeto usuario que NAO existe, atravez da procura de um ID NAO CADASTRADO
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
    public void deveRetornarFalseDelecaoUsuario() {
    	CrudUsuario crud = new CrudUsuario();
    	crud.create(usuario1);
    	crud.create(usuario2);
    	crud.create(usuario3);
    	crud.create(usuario4);
    	
        Assertions.assertFalse(crud.delete(9));
    }
	
	//teste que verifica o uma excessao caso um username ja exista , ao criar um usuario novo, pelo metodo CREATE
	//verifica tambem se o a excessao devolve a string "Username ja existente"
	//teste realizado atravez da inclusao de um usuario com o USERNAME ja cadastrado
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
	public void deveEstourarExcessaoUsernameDuplicado() {
		CrudUsuario crud = new CrudUsuario();
		crud.create(usuario1);
		
    	Usuario usuarioRepetido = new Usuario(5,"username1","password5","nome5","email5");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> crud.create(usuarioRepetido));
	
		Assertions.assertEquals("Username ja existente", exception.getMessage());
		
	}
	
	//teste que verifica o retorno 'True' ao criar um novo usuario, pelo metodo CREATE
	//teste realizado atravez da adicao de um usuario novo, sem um USERNAME cadastrado  
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
	public void deveRetornarTrueCriacaoNovoUsuario() {
		CrudUsuario crud = new CrudUsuario();
		crud.create(usuario1);
		
    	Usuario usuarioNovo = new Usuario(5,"username5","password5","nome5","email5");
		
    	Assertions.assertTrue(crud.create(usuarioNovo));
		
	}
	
	//teste que verifica o retorno 'True' ao atualizar dados de um usuario, buscando pelo ID
	//teste realizado atravez da inclusao de um ID valido, e um objeto USUARIO com dados colocados corretamentes. Apos isso verifica se o objeto foi realmente atualizado no assertEquals
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
	public void deveRetornarTrueSeIdExistirUpdate() {
		CrudUsuario crud = new CrudUsuario();
		crud.create(usuario1);
    	crud.create(usuario2);
    	crud.create(usuario3);
    	crud.create(usuario4);
    	
    	Usuario usuario5 = new Usuario(3,"username5","password5","nome5","email5");
    	
    	
    	Assertions.assertTrue(crud.update(3, usuario5));
    	Assertions.assertEquals(usuario5.toString(), crud.findById(3));
	}
	
	
	//teste que verifica o retorno 'False' ao atualizar dados de um usuario, buscando pelo ID
	//teste realizado atravez da inclusao de um ID NAO valido, e um objeto USUARIO com dados colocados corretamentes
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
	public void deveRetornarFalseSeIdNaoExistirUpdate(){
		CrudUsuario crud = new CrudUsuario();
		crud.create(usuario1);
    	crud.create(usuario2);
    	crud.create(usuario3);
    	crud.create(usuario4);
    	
    	Usuario usuario5 = new Usuario(5,"username5","password5","nome5","email5");
    	
    	Assertions.assertFalse(crud.update(7, usuario5));
	}

	//teste que verifica se o crud retorna o mesmo objeto do que foi cadastrado, atravez do ID
	//teste feito atravez da igualdade do retorno do toString do objeto USUARIO alocado no array do objeto CrudUsuario, e o proprio objeto alocado no CrudUsuario
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
	public void deveRetornarStringDoUsuarioPorId() {
		CrudUsuario crud = new CrudUsuario();
    	crud.create(usuario1);
    	crud.create(usuario2);
    	crud.create(usuario3);
    	crud.create(usuario4);
    	
    	Assertions.assertEquals(usuario2.toString(), crud.findById(2));
	}
	
	//teste que verifica se o crud retorna mensagem padrao ao nao encontrar o id passado nos objetos Usuario
	//teste feito atravez da espera mensagem de retorno padrao do metodo findById quando o ID passado nao é encontrado, e um ID inexistente no objeto CrudUsuario 
	//motivo do teste para saber se o metodo esta funcionando corretamente
	@Test
	public void deveRetornarStringDeErroDoUsuarioPorId() {
		CrudUsuario crud = new CrudUsuario();
    	crud.create(usuario1);
    	crud.create(usuario2);
    	crud.create(usuario3);
    	crud.create(usuario4);
    	
    	Assertions.assertEquals("id nao encontrado", crud.findById(7));
		
	}
	
}
