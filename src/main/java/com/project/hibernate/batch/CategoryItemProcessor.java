package com.project.hibernate.batch;



import com.project.hibernate.pojos.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class CategoryItemProcessor implements ItemProcessor<Category, Category> {

    @Override
    public Category process(Category person) throws Exception {
        final String firstName = person.getName().toUpperCase();
        final String lastName = person.getDescription();
        final Category transformedPerson = new Category(firstName, lastName);
        

        return transformedPerson;
    }
}