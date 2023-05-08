package lsp;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/8
 */
public abstract class SocialMedia {
	public abstract  void chatWithFriend();

	public abstract  void sendPhotosAndVideos();

	// FIXME: LSP
	public abstract void publishPost(Object post);
	// FIXME: LSP
	public abstract  void groupVideoCall(String... users);

}
