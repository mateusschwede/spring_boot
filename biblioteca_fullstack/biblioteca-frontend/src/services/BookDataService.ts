import http from "@/http-common";

class BookDataService {
    getAll(): Promise<any> {
        return http.get("/books");
    }

    get(id: number): Promise<any> {
        return http.get(`/books/${id}`);
    }

    create(data: any): Promise<any> {
        return http.post("/books", data);
    }

    update(id: number, data: any): Promise<any> {
        return http.put(`/books/${id}`, data);
    }

    delete(id: number): Promise<any> {
        return http.delete(`/books/${id}`);
    }
}

export default new BookDataService();