package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import connectionjdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class BancoTesteJdbc {

	@Test
	public void initBank() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Teste3");
		userposjava.setEmail("example3@gmail.com");

		userPosDAO.salvar(userposjava);
	}

	@Test
	public void initListar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(2L);

			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() {
		try {
			UserPosDAO dao = new UserPosDAO();

			Userposjava objetoBanco = dao.buscar(5L);

			objetoBanco.setNome("Nome mudado com o metodo atualizado");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test
	public void initDeletar() {
		try {

			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(19) 9 7321-1287");
		telefone.setTipo("Casa");
		telefone.setUsuario(10L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFonesUser () {
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(10L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------");
		}
		
	}
	
	@Test
	public void testeDelteUserFone () {
		UserPosDAO dao = new UserPosDAO();
		
		dao.deletaFonesPorUser(9L);
		
		
	}
	
}
