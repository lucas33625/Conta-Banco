package Entities;

public class Account {
    private Integer numeroConta;
    private String titular;
    private Double saldoInicial;
    private Double limiteSaque;

    public Account(Integer numeroConta, String titular, Double saldoInicial, Double limiteSaque) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldoInicial = saldoInicial;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public void depositar (Double valor) {
        saldoInicial += valor;
        System.out.println("Número da conta: " + numeroConta + ", Titular: " + titular + ", Novo saldo R$ " + String.format("%.2f", saldoInicial));
    }

    public void sacar (Double valorSaque) throws SaldoInsuficienteException, LimiteSaqueExcedidoException {
        if (valorSaque > saldoInicial) {
            throw new SaldoInsuficienteException("Erro: Valor de saque maior que o saldo.");
        }
        if (valorSaque > limiteSaque) {
            throw new LimiteSaqueExcedidoException("Erro: O valor de saque é maior que o limite de saque.");
        }
        saldoInicial -= valorSaque;
        System.out.println("Número da conta: " + numeroConta + ", Titular: " + titular + ", Novo saldo R$ " + String.format("%.2f", saldoInicial));
    }

    public static class LimiteSaqueExcedidoException extends Exception {
        public LimiteSaqueExcedidoException(String mensagem) {
            super(mensagem);
        }
    }

    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    public String toString (){
        return "Número da conta: "
                + numeroConta
                + ", Titular: "
                + titular
                + ", Saldo Inicial: R$ "
                + String.format("%.2f", saldoInicial);
    }

}
