package com.br.zup.faceZup.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class PostagemModel {

	@Entity
	public class Postagem implements Serializable{
		private static final long serialVersionUID = 1l;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private String foto;
		@NotNull
		private String usuario;

		private String post;

		public Postagem() {

		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getFoto() {
			return foto;
		}
		public void setFoto(String foto) {
			this.foto = foto;
		}

		public String getUsuario() {
			return usuario;
		}
		public String getPost() {
			return post;
		}

		public void setPost(String post) {
			this.post = post;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		@Override
		public String toString() {
			StringBuilder modelo = new StringBuilder();

			modelo.append("Usuario: "+this.usuario);
			modelo.append("\n");
			modelo.append("Postou: "+this.post);

			return modelo.toString();
		}
	}
}