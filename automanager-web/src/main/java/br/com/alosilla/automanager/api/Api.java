package br.com.alosilla.automanager.api;

public class Api {
	
	private final static String URL_BASE = "http://localhost:8080/automanager-web/api";
	
	public static class Veiculos {
		
		public final static String SELF = URL_BASE + "/veiculos/{id}";
		public final static String USO = URL_BASE + "/veiculos/usar/{id}";
		public final static String MARCAS = URL_BASE + "/veiculos/marcas";
		
		public static class Abastecimentos {
			public final static String ABASTECIMENTOS = URL_BASE + "/veiculos/{idVeiculo}/abastecimentos";
			public final static String SELF = URL_BASE + "/veiculos/{idVeiculo}/abastecimentos/{id}";
		}
//		
//		public static class Endereco {
//			public final static String ENDERECOS = URL_BASE + "/usuarios/{idUsuario}/enderecos";
//			public final static String SELF = URL_BASE + "/usuarios/{idUsuario}/enderecos/{id}";
//		}
	}
	
//	public static class Categoria {
//		public final static String CATEGORIAS = URL_BASE + "/categorias";
//		public final static String SELF = URL_BASE + "/categorias/{id}";
//	}
//	
//	public static class PerfilUsuario {
//		public final static String PERFIS_USUARIO = URL_BASE + "/perfil-usuario";
//		public final static String SELF = URL_BASE + "/perfil-usuario/{id}";
//	}
	
	/*
	 * public static class Filmes {
	 * 
	 * public final static String SELF = URL_BASE + "/filmes"; public final
	 * static String SELF_ID = URL_BASE + "/filmes/{id}"; }
	 * 
	 * public static class Locacoes {
	 * 
	 * public final static String SELF = URL_BASE + "/locacoes"; public final
	 * static String SELF_ID = URL_BASE + "/locacoes/{id}"; public final static
	 * String ITENS = URL_BASE + "/locacoes/{id}/itens";
	 * 
	 * public static class Itens {
	 * 
	 * public final static String SELF = Locacoes.SELF_ID + "/itens"; public
	 * final static String SELF_ID = Locacoes.SELF_ID + "/itens/{id}"; }
	 * 
	 * }
	 */
}
