CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,

                        user_id BIGINT NOT NULL,

                        status VARCHAR(30) NOT NULL,

                        total NUMERIC(12, 2) NOT NULL DEFAULT 0,

                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                        updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                        CONSTRAINT order_total_non_negative
                            CHECK (total >= 0),

                        CONSTRAINT order_status_valid
                            CHECK (
                                status IN (
                                           'PENDING',
                                           'RESERVED',
                                           'PAYMENT_PENDING',
                                           'CONFIRMED',
                                           'CANCELLED'
                                    )
                                )
);

CREATE TABLE order_items (
                             id BIGSERIAL PRIMARY KEY,

                             order_id BIGINT NOT NULL,

                             product_id BIGINT NOT NULL,

                             quantity INTEGER NOT NULL,

                             unit_price NUMERIC(12, 2) NOT NULL,

                             subtotal NUMERIC(12, 2) NOT NULL,

                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                             CONSTRAINT order_item_quantity_positive
                                 CHECK (quantity > 0),

                             CONSTRAINT order_item_unit_price_non_negative
                                 CHECK (unit_price >= 0),

                             CONSTRAINT order_item_subtotal_non_negative
                                 CHECK (subtotal >= 0),

                             CONSTRAINT order_item_order_fk
                                 FOREIGN KEY (order_id)
                                     REFERENCES orders(id)
                                     ON DELETE CASCADE
);