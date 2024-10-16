package pl.zabrze.zs10.quiz4p1;
public class Pytanie {
    private String tresc;
    private String podpowiedz;
    private boolean odpPoprawna;
    private boolean czyUdzielonoPoprawnejOdpowiedzi;

    public Pytanie(String tresc, String podpowiedz, boolean odpPoprawna) {
        this.tresc = tresc;
        this.podpowiedz = podpowiedz;
        this.odpPoprawna = odpPoprawna;
        czyUdzielonoPoprawnejOdpowiedzi = false;
    }

    public void setCzyUdzielonoPoprawnejOdpowiedzi() {
        this.czyUdzielonoPoprawnejOdpowiedzi = true;
    }

    public String getTresc() {
        return tresc;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public boolean isOdpPoprawna() {
        return odpPoprawna;
    }

    public boolean isCzyUdzielonoPoprawnejOdpowiedzi() {
        return czyUdzielonoPoprawnejOdpowiedzi;
    }
}
