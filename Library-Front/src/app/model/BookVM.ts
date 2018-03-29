export interface BookVM {
    bookId: number;
    bookTitle: string;
    description: string;
    price: number;
    authorsId: number[];
    categoryId: number;
    editorId: number;
    pubDate: Date;
    popular: Boolean;
    imagePath: string
}