import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { ProductCard } from "@/components/products/ProductCard"

const products = [
    {
        id: 1,
        name: "Laptop Pro",
        price: 899.99,
        category: "Tecnología",
        image: "https://images.unsplash.com/photo-1496181133206-80ce9b88a853",
    },
    {
        id: 2,
        name: "Teclado Mecánico",
        price: 79.99,
        category: "Accesorios",
        image: "https://images.unsplash.com/photo-1587829741301-dc798b83add3",
    },
    {
        id: 3,
        name: "Mouse Inalámbrico",
        price: 39.99,
        category: "Accesorios",
        image: "https://images.unsplash.com/photo-1527814050087-3793815479db",
    },
    {
        id: 4,
        name: "Monitor 27\"",
        price: 299.99,
        category: "Tecnología",
        image: "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf",
    },
    {
        id: 5,
        name: "Audífonos",
        price: 129.99,
        category: "Audio",
        image: "https://images.unsplash.com/photo-1505740420928-5e560c06d30e",
    },
    {
        id: 6,
        name: "Smartphone",
        price: 699.99,
        category: "Tecnología",
        image: "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9",
    },
]

const categories = [
    "Todos",
    "Computadoras",
    "Perifericos",
    "Monitores",
    "Celulares",
    "Tablets",
    "Audio",
    "Videojuegos",
    "Accesorios",
    "Almacenamiento",
    "Redes",
    "Impresoras",
    "Componentes"
]

export default function ProductsPage() {
    return (
        <div className="mx-auto w-full max-w-32xl space-y-8 px-6 py-8">
            {/* Encabezado */}
            <div className="space-y-2">
                <h1 className="text-3xl font-bold tracking-tight">
                    Productos
                </h1>

                <p className="text-muted-foreground">
                    Explora nuestro catálogo de productos.
                </p>
            </div>

            {/* Buscador */}
            <div className="max-w-xl">
                <Input
                    placeholder="Buscar productos..."
                    className="h-11"
                />
            </div>

            {/* Categorías */}
            <div className="flex flex-wrap gap-2">
                {categories.map((category) => (
                    <Button
                        key={category}
                        value={category}
                        variant={category === "Todos" ? "default" : "outline"}
                    >
                        {category}
                    </Button>
                ))}
            </div>

            {/* Productos */}
            <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
                {products.map((product) => (
                    <ProductCard
                        key={product.id}
                        name={product.name}
                        price={product.price}
                        category={product.category}
                        image={product.image}
                    />
                ))}
            </div>
        </div>
    )
}