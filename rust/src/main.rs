use std::time::SystemTime;

mod utils;
mod problems {
    pub mod p35;
    pub mod p36;
}

fn main() {
    execute_problem("P35", crate::problems::p35::p35);
    execute_problem("P36", crate::problems::p36::p36);
}

fn execute_problem(label: &str, func: fn() -> String) {
    println!("# {}", label);

    let start_time = SystemTime::now();
    let result = func();
    let execution_time = start_time.elapsed().unwrap();

    println!("Result: {}\nDuration: {:?}\n", result, execution_time);
}