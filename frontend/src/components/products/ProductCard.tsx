import { Button } from "@/components/ui/button"
import {
    Card,
    CardContent,
    CardFooter,
} from "@/components/ui/card"

interface ProductCardProps {
    name: string
    price: number
    category: string
    image: string
}

export function ProductCard({
                                name,
                                price,
                                category,
                                image,
                            }: ProductCardProps) {
    return (
        <Card className="overflow-hidden">
            <div className="aspect-square overflow-hidden bg-muted">
                <img
                    src={image}
                    alt={name}
                    className="h-full w-full object-cover transition-transform duration-300 hover:scale-105"
                />
            </div>

            <CardContent className="space-y-2 p-4">
                <p className="text-sm text-muted-foreground">
                    {category}
                </p>

                <h3 className="font-semibold">
                    {name}
                </h3>

                <p className="text-lg font-bold">
                    ${price.toFixed(2)}
                </p>
            </CardContent>

            <CardFooter className="p-4 pt-0">
                <Button className="w-full">
                    Agregar al carrito
                </Button>
            </CardFooter>
        </Card>
    )
}