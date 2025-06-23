<template>
    <div v-if="currentBook.id">
        <h4>Livro {{ currentBook.id }} - {{ currentBook.title }}</h4>
        <form @submit.prevent="updateBook">
            <input type="text" class="form-control" placeholder="Título" id="title" required v-model="currentBook.title"
                name="title" />
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Autor(a)" id="author" required
                    v-model="currentBook.author" name="author" />
            </div>
            <div class="form-group">
                <label for="published_date">Publicação:</label>
                <input type="date" class="form-control" id="published_date"
                    :max="new Date().toISOString().split('T')[0]" required v-model="currentBook.published_date"
                    name="published_date" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="ISBN" pattern="^\d{13}$" id="isbn" required
                    v-model="currentBook.isbn" name="isbn" />
            </div>
            <div class="form-group">
                <input type="number" class="form-control" placeholder="Páginas" id="pages" min="1" required
                    v-model="currentBook.pages" name="pages" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Capa" id="cover" v-model="currentBook.cover"
                    name="cover" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Idioma" id="language" required
                    v-model="currentBook.language" name="language" />
            </div>
            <button type="button" @click="$router.push('/books')" class="btn btn-secondary">Cancelar</button>
            <button type="submit" class="btn btn-warning">Confirmar</button>
        </form>
        <p>{{ message }}</p>
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import BookDataService from "@/services/BookDataService";
import Book from "@/types/Book";
import ResponseData from "@/types/ResponseData";

export default defineComponent({
    name: "BookDetails",
    data() {
        return {
            currentBook: {} as Book,
            message: "",
        };
    },
    methods: {
        getBook(id: any) {
            BookDataService.get(id)
                .then((response: ResponseData) => {
                    this.currentBook = response.data;
                })
                .catch((e: Error) => {
                    console.log(e);
                });
        },

        updateBook() {
            BookDataService.update(this.currentBook.id, this.currentBook)
                .then((response: ResponseData) => {
                    this.$router.push({ name: "books" });
                })
                .catch((e: Error) => {
                    console.log(e);
                    this.message = "Erro ao adicionar livro";
                });
        },

        deleteBook(id: number) {
            BookDataService.delete(this.currentBook.id)
                .then((response: ResponseData) => {
                    console.log(response.data);
                    this.$router.push({ name: "books" });
                })
                .catch((e: Error) => {
                    console.log(e);
                });
        },
    },
    mounted() {
        this.message = "";
        this.getBook(this.$route.params.id);
    },
});
</script>

<style></style>