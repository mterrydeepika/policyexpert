# Notes

Please add here any notes, assumptions and design decisions that might help us understand your thought process.

I've implemented the ItemByUnitDiscount- Buy One Get One Free where you can apply a discount to an Item By Weight and a
or choose not to apply discount to that item.
I've used productId to identity the item by the product to add an item to the basket in the case of Buy One Get One Free.
If an even number of Items is already present, I would just be calculating the discount without a need to add one more 
item to basket.

I've also implemented ItemByWeight Discount - BuyOneKgAtHalfPrice. It will apply discount by default to all items that 
apply to the condition.