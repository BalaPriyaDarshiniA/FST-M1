class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")

car1 = Car("Toyota", "Corolla", "2015", "Manual", "White")
car2 = Car("Renault", "Kwid", "2024", "Automatic", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Manual", "Black")

car2.accelerate()
car1.stop()