package ma.enset.services;

import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    public void process() {
        System.out.println("Business process...");
    }

    @Override
    public double compute() {
        double data = Math.random();
        System.out.println("Business computing and returning");
        return data;
    }
}
