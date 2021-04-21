package videoStore;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Movie {
    private String title;
    private LocalDate releaseDate;
    private Duration movieLength;
    private String country;
    private String description;
    private Audience classification;
    private Genre movieGenre;
    private int stock=0;
    private int rent=0;

    public Movie(String title,String country, LocalDate releaseDate,int movieLength,Audience classification, Genre movieGenre,int stock){
        this.title=title;
        this.country=country;
        setMovieLength(movieLength);
        this.releaseDate=releaseDate;
        this.classification=classification;
        this.movieGenre=movieGenre;
        this.stock=stock;
    }

    public int getRent() {
        return rent;
    }

    public  void setRent() {
        this.rent++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int year,int month, int date) {
        this.releaseDate = LocalDate.of(year, month, date);
    }

    public Duration getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = Duration.of(movieLength, ChronoUnit.MINUTES);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Audience getClassification() {
        return classification;
    }

    public void setClassification(Audience classification) {
        this.classification = classification;
    }

    public Genre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(Genre movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock += stock;
    }
    public void discountStock(){
        this.stock--;
    }
}
