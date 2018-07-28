package db.hotel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import db.hotel.model.AbstractEntity;

@Entity @SequenceGenerator(name = "reserva_id", sequenceName = "reserva_seq", allocationSize = 1)
public class Reserva extends  AbstractEntity {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_id")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicial;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCheckIn;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCheckOut;

	private boolean pago;
	private String formaPagamento;
	private String status;
	private float valorPago;

	@ManyToMany(mappedBy = "reservas")
	private List<Hospede> hospedes;

	@ManyToOne
	private Funcionario funcionario;

	@OneToMany(mappedBy = "reserva")
	private List<Consumo> consumos;

	@ManyToOne
	private Quarto quarto;

	public Reserva(Long id, Date dataInicial, Date dataFinal, Date dataCheckIn, Date dataCheckOut, boolean pago,
			String formaPagamento, String status, float valorPago) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
		this.pago = pago;
		this.formaPagamento = formaPagamento;
		this.status = status;
		this.valorPago = valorPago;
	}

	public Reserva() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataCheckIn() {
		return dataCheckIn;
	}

	public void setDataCheckIn(Date dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public Date getDataCheckOut() {
		return dataCheckOut;
	}

	public void setDataCheckOut(Date dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public List<Hospede> getHospedes() {
		return hospedes;
	}

	public void setHospedes(List<Hospede> hospedes) {
		this.hospedes = hospedes;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
