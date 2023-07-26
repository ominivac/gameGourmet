package game;

public class No<Prato> {
	private Prato prato;
	private No<Prato> noPai;
	private No<Prato> noEsquerda;
	private No<Prato> noDireita;

	public No(Prato prato, No<Prato> noEsquerda, No<Prato> noDireita) {
		this.prato = prato;
		this.noEsquerda = noEsquerda;
		this.noDireita = noDireita;
	}

	public No() {
		this.noDireita = new No<Prato>(null, null, null);
		this.noEsquerda = new No<Prato>(null, null, null);
	}

	public boolean isEmpty() {
		return this.prato == null;
	}

	public boolean ehFolha() {
		return this.prato != null && this.noEsquerda.isEmpty() && this.noDireita.isEmpty();
	}

	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}

	public No<Prato> getNoPai() {
		return noPai;
	}

	public void setNoPai(No<Prato> noPai) {
		this.noPai = noPai;
	}

	public No<Prato> getNoEsquerda() {
		return noEsquerda;
	}

	public void setNoEsquerda(No<Prato> noEsquerda) {
		this.noEsquerda = noEsquerda;
	}

	public No<Prato> getNoDireita() {
		return noDireita;
	}

	public void setNoDireita(No<Prato> noDireita) {
		this.noDireita = noDireita;
	}

	@Override
	public String toString() {
		String resp = "NIL";
		if (!isEmpty()) {
			resp = prato.toString();
		}
		return resp;
	}

	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj instanceof No) {
			if (!this.isEmpty() && !((No<Prato>) obj).isEmpty()) {
				resp = this.prato.equals(((No<Prato>) obj).prato);
			} else {
				resp = this.isEmpty() && ((No<Prato>) obj).isEmpty();
			}

		}
		return resp;
	}
}
