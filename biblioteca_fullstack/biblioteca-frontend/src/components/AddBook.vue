<template>
    <h3>Novo livro:</h3>
    <form @submit.prevent="saveBook">
        <input type="text" class="form-control" placeholder="Título" id="title" required v-model="book.title"
            name="title" />
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Autor(a)" id="author" required v-model="book.author"
                name="author" />
        </div>
        <div class="form-group">
            <label for="published_date">Publicação:</label>
            <input type="date" class="form-control" id="published_date" :max="new Date().toISOString().split('T')[0]"
                required v-model="book.published_date" name="published_date" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="ISBN" pattern="^\d{13}$" id="isbn" required
                v-model="book.isbn" name="isbn" />
        </div>
        <div class="form-group">
            <input type="number" class="form-control" placeholder="Páginas" id="pages" min="1" required
                v-model="book.pages" name="pages" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Capa" id="cover" v-model="book.cover" name="cover" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Idioma" id="language" required v-model="book.language"
                name="language" />
        </div>
        <button type="button" @click="$router.push('/books')" class="btn btn-secondary">Cancelar</button>
        <button type="submit" class="btn btn-success">Adicionar</button>
    </form>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import BookDataService from "@/services/BookDataService";
import Book from "@/types/Book";
import ResponseData from "@/types/ResponseData";

export default defineComponent({
    name: "add-book",
    data() {
        return {
            book: {

                title: "",
                author: "",
                published_date: new Date(),
                isbn: "",
                pages: 0,
                cover: "",
                language: "",
            } as Book,
        };
    },
    methods: {
        saveBook() {
            let data = {
                title: this.book.title,
                author: this.book.author,
                published_date: this.book.published_date,
                isbn: this.book.isbn,
                pages: this.book.pages,
                cover: this.book.cover,
                language: this.book.language,
            };

            BookDataService.create(data)
                .then((response: ResponseData) => {
                    this.book.id = response.data.id;
                    this.$router.push({ name: "books" });
                })
                .catch((e: Error) => {
                    console.log(e);
                });
        },
    },
});
</script>

<style></style>