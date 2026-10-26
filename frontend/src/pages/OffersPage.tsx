import { Tag } from "lucide-react"

import {
    Card,
    CardContent,
    CardFooter,
} from "@/components/ui/card"

import { Button } from "@/components/ui/button"

const offers = [
    {
        id: 1,
        name: "Laptop Pro",
        category: "Computadoras",
        originalPrice: 999.99,
        price: 799.99,
        discount: 20,
    },
    {
        id: 2,
        name: "Monitor 27\"",
        category: "Monitores",
        originalPrice: 349.99,
        price: 279.99,
        discount: 20,
    },
    {
        id: 3,
        name: "Audífonos Pro",
        category: "Audio",
        originalPrice: 149.99,
        price: 99.99,
        discount: 33,
    },
    {
        id: 4,
        name: "Teclado Mecánico",
        category: "Periféricos",
        originalPrice: 119.99,
        price: 89.99,
        discount: 25,
    },
]

export default function OffersPage() {
    return (
        <div className="mx-auto w-full max-w-32xl space-y-8">

            {/* Encabezado */}
            <section className="space-y-2">
                <div className="flex items-center gap-3">
                    <div className="rounded-lg bg-primary/10 p-2">
                        <Tag className="h-6 w-6" />
                    </div>

                    <h1 className="text-3xl font-bold tracking-tight">
                        Ofertas
                    </h1>
                </div>

                <p className="text-muted-foreground">
                    Aprovecha nuestros productos con descuentos especiales.
                </p>
            </section>

            {/* Productos */}
            <section className="grid gap-6 sm:grid-cols-2 lg:grid-cols-4">

                {offers.map((product) => (
                    <Card
                        key={product.id}
                        className="overflow-hidden"
                    >
                        {/* Imagen temporal */}
                        <div className="relative aspect-square bg-muted">
                            <div className="flex h-full items-center justify-center text-muted-foreground">
                                Imagen del producto
                            </div>

                            <div className="absolute right-3 top-3 rounded-full bg-destructive px-3 py-1 text-sm font-semibold text-destructive-foreground">
                                -{product.discount}%
                            </div>
                        </div>

                        <CardContent className="space-y-3 p-4">

                            <p className="text-sm text-muted-foreground">
                                {product.category}
                            </p>

                            <h2 className="font-semibold">
                                {product.name}
                            </h2>

                            <div className="flex items-center gap-3">
                                <span className="text-xl font-bold">
                                    ${product.price.toFixed(2)}
                                </span>

                                <span className="text-sm text-muted-foreground line-through">
                                    ${product.originalPrice.toFixed(2)}
                                </span>
                            </div>

                        </CardContent>

                        <CardFooter className="p-4 pt-0">
                            <Button className="w-full">
                                Agregar al carrito
                            </Button>
                        </CardFooter>
                    </Card>
                ))}

            </section>

        </div>
    )
}