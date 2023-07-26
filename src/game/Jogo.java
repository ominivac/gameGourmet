package game;

import javax.swing.JOptionPane;



public class Jogo {
	public static void main(String[] args) {
		
		No<Prato> noEsquerda = new No<Prato>();
		noEsquerda.setPrato(new Prato("Bolo de Chocolate"));
		
		No<Prato> raiz = new No<Prato>(new Prato("Lasanha", "Massa"), noEsquerda, new No<Prato>());
		
		while (true) {
			Object[] optionOk = { "OK" };
		    if(JOptionPane.showOptionDialog(null, "Pense em um prato que gosta ", "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, optionOk, optionOk[0]) == -1) {
		    	break;
		    }
			comecar(raiz, raiz.getPrato().toString());
		}
	}
	
	
	private static void comecar(No<Prato> no, String pratoEhUltimo) {
		if (no.getPrato().getDescricao() == null) {
			if (!no.getNoEsquerda().isEmpty()) {
				comecar(no.getNoEsquerda(), no.getPrato().toString());
			} else {
				isPrato(no, no.getPrato().toString(), "esquerda");
			}
		} else {
			String perguntaPrato = "O prato que você pensou é " + no.getPrato().getDescricao();
		    Object[] options = { "Sim", "Não" };
		    int descricaoPrato = JOptionPane.showOptionDialog(null, perguntaPrato, "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			

			if (descricaoPrato == 0) {
				if (!no.getNoDireita().isEmpty()) {
					comecar(no.getNoDireita(), no.getPrato().toString());
				} else {
					isPrato(no, no.getPrato().toString(), "direita");
				}
			} else {
				if (!no.getNoEsquerda().isEmpty()) {
					comecar(no.getNoEsquerda(), pratoEhUltimo);
				} else {
					isPrato(no, pratoEhUltimo, "esquerda");
				}
			}
		}
	}
	
	private static void addPrato(No<Prato> no, String pratoUltimoSim, String direcao) {
		String nomePrato = JOptionPane.showInputDialog("Qual prato você pensou ?");
		String perguntaNovaDescricao = nomePrato + " é _____ mas, " + pratoUltimoSim + " não ";
		String descricaoPrato = JOptionPane.showInputDialog(perguntaNovaDescricao);

		No<Prato> noNovoPrato = new No<>();
		noNovoPrato.setPrato(new Prato(nomePrato, descricaoPrato));

		if (direcao.equals("direita")) {
			no.setNoDireita(noNovoPrato);
			no.getNoDireita().setNoPai(no);
		} else {
			no.setNoEsquerda(noNovoPrato);
			no.getNoEsquerda().setNoPai(no);
		}
	}

	
	private static void isPrato(No<Prato> no, String prato, String direcao) {
		String respostaPrato = "O prato que você pensou é " + prato + " ?";
		Object[] options = { "Sim", "Não" };
	    int pratoCorreto = JOptionPane.showOptionDialog(null, respostaPrato, "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if (pratoCorreto == 0) {
			Object[] optionOk = { "OK"};
		    JOptionPane.showOptionDialog(null, "Acertei de novo!", "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, optionOk, optionOk[0]);
		} else {
			addPrato(no, prato, direcao);
		}
	}

	
	
}