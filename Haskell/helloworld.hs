fact :: (Num a, Ord a) => a -> a
fact 0 = 1
fact n 
    | n > 0 = n * fact (n - 1)
    | n < 0 = error "Undefined factorial"

fib :: (Num a1, Num a2, Ord a1) => a1 -> a2
fib 0 = 0
fib 1 = 1
fib n
    | n > 1 = fib (n - 1) + fib (n - 2)
    | n < 0 = error "Undefined fibonacci number"

fibRng :: Num a => Int -> [a]
fibRng n
    | n < 0     = error "Undefined fibonacci range"
    | n == 0    = []
    | n == 1    = [0]
    | otherwise = reverse (fibInner 0 1 [1, 0] n)

fibInner :: Num a => a -> a -> [a] -> Int -> [a]
fibInner x y acc l
    | length acc == l   = acc
    | otherwise         = fibInner y z (z:acc) l
    where z = x + y
    