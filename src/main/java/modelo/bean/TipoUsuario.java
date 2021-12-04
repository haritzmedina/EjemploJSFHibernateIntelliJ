package modelo.bean;
 
public class TipoUsuario {
	public String tipoUsu;
	public int codigo;
	
	public TipoUsuario(int codigo, String tipoUsu){
		this.tipoUsu=tipoUsu;
		this.codigo=codigo;
	}
	public String getTipoUsu() {
		return tipoUsu;
	}
	public void setTipoUsu(String tipoUsu) {
		this.tipoUsu = tipoUsu;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String toString(){
		return tipoUsu;
	}
}
