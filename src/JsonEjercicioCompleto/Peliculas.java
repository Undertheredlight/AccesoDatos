/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JsonEjercicioCompleto;

/**
 *
 * @author Liz
 */
public class Peliculas {
    private String tittle;
    private int episodio;
    private String opening_crawl;
    private String director;

    public Peliculas(String tittle, int episodio, String opening_crawl, String director) {
        this.tittle = tittle;
        this.episodio = episodio;
        this.opening_crawl = opening_crawl;
        this.director = director;
    }

    public String getTittle() {
        return tittle;
    }

    public int getEpisodio() {
        return episodio;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
