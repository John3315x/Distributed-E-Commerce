import { Button } from "@/components/ui/button"
import {
    Card,
    CardContent,
    CardFooter,
} from "@/components/ui/card"

const products = [
    {
        id: 1,
        name: "Producto Premium",
        price: "$49.99",
        category: "Destacados",
    },
    {
        id: 2,
        name: "Producto Esencial",
        price: "$29.99",
        category: "Populares",
    },
    {
        id: 3,
        name: "Producto Especial",
        price: "$79.99",
        category: "Nuevos",
    },
    {
        id: 4,
        name: "Producto Básico",
        price: "$19.99",
        category: "Ofertas",
    },
]

export default function DashboardPage() {
    return (
        <div className="min-h-screen">
            {/* Hero */}
            <section className="relative overflow-hidden rounded-2xl border bg-muted/40 px-6 py-16 md:px-12 md:py-24">
                <div className="max-w-2xl space-y-6">
                    <div className="space-y-2">
                        <p className="text-sm font-medium text-muted-foreground">
                            NUEVA COLECCIÓN
                        </p>

                        <h1 className="text-4xl font-bold tracking-tight md:text-6xl">
                            Encuentra lo que estás buscando.
                        </h1>

                        <p className="text-lg text-muted-foreground">
                            Explora nuestra colección de productos y encuentra aquello
                            que necesitas.
                        </p>
                    </div>

                    <div className="flex flex-wrap gap-3">
                        <Button size="lg">
                            Ver productos
                        </Button>

                        <Button size="lg" variant="outline">
                            Ver ofertas
                        </Button>
                    </div>
                </div>
            </section>

            {/* Productos destacados */}
            <section className="mt-16 space-y-6">
                <div>
                    <h2 className="text-2xl font-bold tracking-tight">
                        Productos destacados
                    </h2>

                    <p className="text-muted-foreground">
                        Algunos productos que podrían interesarte.
                    </p>
                </div>

                <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
                    {products.map((product) => (
                        <Card
                            key={product.id}
                            className="overflow-hidden transition-shadow hover:shadow-md"
                        >
                            {/* Imagen temporal */}
                            <div className="flex aspect-square items-center justify-center bg-muted">
                <span className="text-sm text-muted-foreground">
                  Imagen
                </span>
                            </div>

                            <CardContent className="space-y-2 pt-6">
                                <p className="text-xs text-muted-foreground">
                                    {product.category}
                                </p>

                                <h3 className="font-semibold">
                                    {product.name}
                                </h3>

                                <p className="text-lg font-bold">
                                    {product.price}
                                </p>
                            </CardContent>

                            <CardFooter>
                                <Button className="w-full" variant="outline">
                                    Ver producto
                                </Button>
                            </CardFooter>
                        </Card>
                    ))}
                </div>
            </section>

            {/* Categorías */}
            <section className="mt-16 space-y-6">
                <div>
                    <h2 className="text-2xl font-bold tracking-tight">
                        Explora por categoría
                    </h2>

                    <p className="text-muted-foreground">
                        Encuentra rápidamente lo que necesitas.
                    </p>
                </div>

                <div className="grid gap-4 sm:grid-cols-2 lg:grid-cols-3">
                    <Button
                        variant="outline"
                        className="h-32 text-lg"
                    >
                        Tecnología
                    </Button>

                    <Button
                        variant="outline"
                        className="h-32 text-lg"
                    >
                        Accesorios
                    </Button>

                    <Button
                        variant="outline"
                        className="h-32 text-lg"
                    >
                        Hogar
                    </Button>
                </div>
            </section>
        </div>
    )
}