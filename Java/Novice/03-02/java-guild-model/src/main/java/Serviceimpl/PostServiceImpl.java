package Serviceimpl;

import Model.Post;
import exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import postrepository.PostRepository;
import service.PostService;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createpost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(long id, Post postRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setContent(postRequest.getDescription());
        return postRepository.save(post);
    }

    @Override
    public Void deletePost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.delete(post);
        return null;
    }





    @Override
    public Post getPostById(long id) {
        Optional<Post> result = postRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }else{
            throw new ResourceNotFoundException("Post", "id", id);
        }

//        Post post = postRepository.findById(id)
//            .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        //return post;
    }
}
