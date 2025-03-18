package cola;

public class Cola {
    private long[] arreglo;
    private int inicio, fin, n;

    public Cola(int n) {
        this.n = n;
        this.arreglo = new long[n];
        this.inicio = 0;
        this.fin = 0;
    }

    public void insert(long e) {
        if (!isFull()) {
            arreglo[fin++] = e;
        } else {
            System.out.println("Cola llena");
        }
    }

    public long remove() {
        if (!isEmpty()) {
            return arreglo[inicio++];
        } else {
            System.out.println("Cola vacía");
            return -1;
        }
    }

    public long peek() {
        if (!isEmpty()) {
            return arreglo[inicio];
        } else {
            System.out.println("Cola vacía");
            return -1;
        }
    }

    public boolean isEmpty() {
        return inicio == fin;
    }

    public boolean isFull() {
        return fin == n;
    }

    public int size() {
        return fin - inicio;
    }
}