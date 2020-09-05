function DisplayPosts() {
  fetch('/posts').then(response => response.json()).then((posts) => {
    const postListElement = document.getElementById('post');
    posts.forEach((postObject) => {
      postListElement.appendChild(createPostElement(postObject));
    })
  });
}

function createPostElement(post) {
  const postElement = document.createElement('li');
  postElement.className = 'post';
  // properties
  const textElement = document.createElement('span');
  textElement.innerText = post.text
  const locationElement = document.createElement('span');
  locationElement.innerText = post.location
  postElement.appendChild(locationElement);
  postElement.appendChild(textElement);
  return postElement;
}