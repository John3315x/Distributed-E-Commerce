CREATE TABLE inventory (
                           id BIGSERIAL PRIMARY KEY,

                           product_id BIGINT NOT NULL,

                           quantity INTEGER NOT NULL DEFAULT 0,

                           reserved_quantity INTEGER NOT NULL DEFAULT 0,

                           version BIGINT NOT NULL DEFAULT 0,

                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                           CONSTRAINT inventory_quantity_non_negative
                               CHECK (quantity >= 0),

                           CONSTRAINT inventory_reserved_non_negative
                               CHECK (reserved_quantity >= 0),

                           CONSTRAINT inventory_reserved_not_greater_than_quantity
                               CHECK (reserved_quantity <= quantity),

                           CONSTRAINT inventory_product_unique
                               UNIQUE (product_id)
);

INSERT INTO public.inventory (product_id, quantity, reserved_quantity, version) VALUES   (1, 25, 0, 0),   (3, 40, 5, 0),   (5, 15, 2, 0),   (7, 30, 0, 0);