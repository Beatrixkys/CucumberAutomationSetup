package steps;

import cucumber.api.java.en.When; 
import cucumber.api.java.en.Then; 
import cucumber.api.java.en.And; 
import cucumber.api.java.en.Given;

import static org.junit.Assert.*;

import configs.APIConfig;
import pages.CommentsAPI; 
import utils.APIHandler;

public class CommentsSteps {
    private CommentsAPI commentsAPI = new CommentsAPI();

    

    @And("the response should contain a comment with ID {int} and email {string}")
    public void the_response_should_contain_a_comment_with_id(int id, String email) {
        assertTrue(commentsAPI.responseContainsCommentWithId(id));
        assertTrue(commentsAPI.responseContainsCommentString("email",email)); 
    }

    @And("the response should contain the new comment with the name {string}")
    public void the_response_should_contain_the_new_comment_with_the_name(String name) {
        assertTrue(commentsAPI.responseContainsCommentString("name",name));
    }
    @And("the response should return a comment ID of {int}")
    public void the_response_should_return_a_comment_id_of(int id) {
        assertEquals(id, (int) commentsAPI.getIdFromResponse());
    }
}