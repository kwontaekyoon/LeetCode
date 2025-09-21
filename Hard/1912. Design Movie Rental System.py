from collections import defaultdict

class MovieRentingSystem:

    def __init__(self, n: int, entries: list[list[int]]):
        
        self.store = defaultdict(int)
        self.films = defaultdict(SortedList) # type: ignore
        self.rental = set()

        for shop, movie, price in entries:
            self.store[(shop, movie)] = price
            self.films[movie].add((price, shop))
            

    def search(self, movie: int) -> list[int]:
        a = self.films[movie][:5]
        return [x[1] for x in a]


    def rent(self, shop: int, movie: int) -> None:

        price = self.store[(shop, movie)]
        self.films[movie].discard((price, shop))
        self.rental.add((price, shop, movie))
        

    def drop(self, shop: int, movie: int) -> None:
 
        price = self.store[(shop, movie)]
        self.films[movie].add((price, shop))
        self.rental.discard((price, shop, movie))
    

    def report(self) -> list[list[int]]:

        report_stores = sorted(self.rental)[:5]
        return [[s, m] for _, s, m in report_stores]

class MovieRentingSystem1:

    def __init__(self, n: int, entries: list[list[int]]):
        self.available = {}  # (shop, movie) -> price
        self.movie_shops = {}  # movie -> list of (price, shop)
        self.rented = set()  # (shop, movie) that are currently rented

        for shop, movie, price in entries:
            self.available[(shop, movie)] = price
            if movie not in self.movie_shops:
                self.movie_shops[movie] = []
            self.movie_shops[movie].append((price, shop))

        # Sort shops by price for each movie initially
        for movie in self.movie_shops:
            self.movie_shops[movie].sort()

    def search(self, movie: int) -> list[int]:
        result = []
        for _, shop in self.movie_shops.get(movie, []):
            if (shop, movie) not in self.rented:
                result.append(shop)
            if len(result) == 5:
                break
        return result

    def rent(self, shop: int, movie: int) -> None:
        self.rented.add((shop, movie))

    def drop(self, shop: int, movie: int) -> None:
        self.rented.discard((shop, movie))

    def report(self) -> list[list[int]]:
        rented_list = []
        for shop, movie in self.rented:
            price = self.available[(shop, movie)]
            rented_list.append((price, shop, movie))

        rented_list.sort()
        return [[shop, movie] for _, shop, movie in rented_list[:5]]