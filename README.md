API Required 
- POST: /deal {Price, Number, ExpiryTime} - response will be created deal structure
- PUT: /deal {numberOfItems, ExpiryTime} - response will be success/failure
- POST: /deal/claim {userId, itemId} - response will be bought item detail
- GET: /deal - Response will be list of items and their quantity

VALIDATION Required
- Users cannot buy the item purchasingTime>expiryTime
- Users cannot buy if the all item are sold.
- One user cannot buy more than one item as part of the deal.

Tables Required
- Deal Table
- Orders Table