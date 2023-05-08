package lsp;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/5/8
 */
public class WhatsApp implements I_SocialMedia, VideoCallManager
//		extends SocialMedia
{
	@Override
	public void chatWithFriend() {
		// Logic
	}

	// FIXME: LSP
	/*
	public void publishPost(Object post) {
		// Not Applicable
	}
	 */
	@Override
	public void sendPhotosAndVideos() {
		// Logic
	}

	@Override
	public void groupVideoCall(String... users) {
		// Logic
	}

	// FIXME: LSP
	/*
	@Override
	public void groupVideoCall(String... users) {
		// Logic
	}
	 */
}
