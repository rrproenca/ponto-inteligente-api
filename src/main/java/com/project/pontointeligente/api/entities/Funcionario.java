/**
 * 
 */
package com.project.pontointeligente.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.project.pontointeligente.api.enums.PerfilEnum;

/**
 * @author Roberto
 *
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1851679105447865760L;
	
	
	private Long id;
	private String name;
	private String email;
	private String senha;
	private String cpf;
	private BigDecimal valorHora;
	private Float qtdHorasTrabalhoDia;
	private Float qtdHorasAlmoco;
	private PerfilEnum perfil;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private Empresa empresa;
	private List<Lancamento> lancamentos;
	
	public Funcionario() {
		
	}
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	@Column(name = "nome", nullable = false)
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @return the cpf
	 */
	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the valorHora
	 */
	@Column(name = "valor_hora", nullable = true)
	public BigDecimal getValorHora() {
		return valorHora;
	}
	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHora);
	}

	/**
	 * @param valorHora the valorHora to set
	 */
	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}
	
	/**
	 * @return the qtdHorasTrabalhoDia
	 */
	@Column(name = "qtd_Horas_Trabalho_Dia", nullable = true)
	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}
	
	@Transient
	public Optional<Float> getQtdHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(qtdHorasTrabalhoDia);
	}
	/**
	 * @param qtdHorasTrabalhoDia the qtdHorasTrabalhoDia to set
	 */
	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}
	/**
	 * @return the qtdHorasAlmoco
	 */
	@Column(name = "qtd_Horas_Almoco", nullable = true)
	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}
	
	@Transient
	public Optional<Float> getQtdHorasAlmocoOpt() {
		return Optional.ofNullable(qtdHorasAlmoco);
	}
	/**
	 * @param qtdHorasAlmoco the qtdHorasAlmoco to set
	 */
	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}
	/**
	 * @return the perfil
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)	
	public PerfilEnum getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	/**
	 * @return the dataCriacao
	 */
	@Column(name = "data_criacao", nullable = false)	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	/**
	 * @return the dataAtualizacao
	 */
	@Column(name = "data_atualizacao", nullable = false)	
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	/**
	 * @param dataAtualizacao the dataAtualizacao to set
	 */
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	/**
	 * @return the empresa
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	public Empresa getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	/**
	 * @return the lancamentos
	 */
	@OneToMany(mappedBy = "funcionario" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	/**
	 * @param lancamentos the lancamentos to set
	 */
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	

	@Override
	public String toString() {
		return "Funcionario [Id="+ id + ", cpf= " + cpf + ", email=" + email + ", senha=" + senha + 
				", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco=" + qtdHorasAlmoco +
				", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ",dataAtualizacao=" + dataAtualizacao + ", empresa=" + empresa + "]";				
	}
}
