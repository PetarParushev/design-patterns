class Subject {
    constructor() {
        this.observers = [];
    }
    subscribe(func) {
        this.observers.push(func);
    }
    unsubscribe(func) {
        this.observers = this.observers.filter(f => {
            if (f != func) {
                return f;
            }
        });
    }
    trigger() {
        this.observers.forEach(func => {
            func.call();
        });
    }
}

const observer = new Subject();

const observable1 = () => {
    console.log('Hi from observable 1.');
}

const observable2 = () => {
    console.log('Hi from observable 2.');
}

observer.subscribe(observable1);
observer.trigger(); // Logs 1
observer.subscribe(observable2);
observer.trigger(); // Logs 1 and 2
observer.unsubscribe(observable1);
observer.trigger(); // Logs 2