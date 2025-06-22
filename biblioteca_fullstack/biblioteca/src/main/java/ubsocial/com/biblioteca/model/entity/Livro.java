package ubsocial.com.biblioteca.model.entity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

    public Livro() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank // NotBlank também é automaticamente NotNull
    @Size(min = 1, max = 255, message = "Título precisa ter entre 1 e 255 caracteres")
    @Column(length = 255)
    private String title;

    @NotBlank
    @Size(min = 1, max = 255, message = "Autor precisa ter entre 1 e 255 caracteres")
    @Column(length = 255)
    private String author;
    
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date published_date;

    @NotBlank
    @Column(unique = true)
    @Size(min = 13, max = 13, message = "ISBN precisa ter 13 caracteres")
    private String isbn;
    
    private int pages;
    
    @Size(min = 1, max = 255, message = "Gênero precisa ter entre 1 e 255 caracteres")
    @Column(length = 255)
    private String cover;

    @NotBlank
    @Size(min = 1, max = 255, message = "Idioma precisa ter entre 1 e 255 caracteres")
    @Column(length = 255)
    public String language;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return published_date;
    }

    public void setPublishedDate(Date published_date) {
        this.published_date = published_date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}